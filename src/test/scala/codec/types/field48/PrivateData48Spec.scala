package codec.types.field48

import codec.ISO8583Definition.PRIVATE_DATA
import codec.types.field48.types.{OperationType4801, TerminalPartialAuthorSupport4806, TrackOrChip4804, TransactionEnvType4803}
import org.scalatest.OptionValues
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers.convertToAnyMustWrapper
import scodec.bits.HexStringSyntax

class PrivateData48Spec extends AnyFlatSpec with OptionValues {
  "Private data (48)" should "be decoded" in {
    val infoSize = hex"0013"
    val type01 = hex"010200"
    val type02 = hex"02040250"
    val type03 = hex"030201"
    val type04 = hex"040202"
    val type05 = hex"050200"
    val type06 = hex"060211"
    val tokenDataHex =
      (infoSize ++ type01 ++ type02 ++ type03 ++ type04 ++ type05 ++ type06).bits

    val result = PRIVATE_DATA.decode(tokenDataHex).toOption.value.value

    result.operationType01.value.code mustBe OperationType4801.OperationType.CREDIT
    result.acceptanceCountryCode02.value.code.getAlpha3 mustBe "FRA"
    result.transactionEnvType03.value.`type` mustBe TransactionEnvType4803.EnvType.PROXIMITY_EVENT
    result.trackOrChip04.value.`type` mustBe TrackOrChip4804.EnvType.CHIP_READING
    result.originTransactionReturnCode05.value.value mustBe "00"
    result.terminalPartialAuthorSupport06.value.`type` mustBe TerminalPartialAuthorSupport4806.TerminalSupport.SUPPORT_ALL

    val encodeResult = PRIVATE_DATA.encode(result).toOption.value
    encodeResult.toHex mustBe tokenDataHex.toHex
  }

}

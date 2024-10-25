package codec.types.field48

import codec.ISO8583Definition.PRIVATE_DATA
import codec.types.field48.types.*
import org.scalatest.OptionValues
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers.convertToAnyMustWrapper
import scodec.bits.HexStringSyntax

class PrivateData48Spec extends AnyFlatSpec with OptionValues {

  "Private data (48)" should "be decoded" in {
    val infoSize = hex"0060"
    val type01   = hex"010200"
    val type02   = hex"02040250"
    val type03   = hex"030201"
    val type04   = hex"040202"
    val type05   = hex"050200"
    val type06   = hex"060211"
    val type07   = hex"070203"
    val type08   = hex"080C000000001234"
    val type09   = hex"09041234"
    val type10   = hex"100204"
    val type11   = hex"110200"
    val type12   = hex"120200"
    val type13   = hex"130227"
    val type14   = hex"14040216"
    val type15   = hex"1506030104"
    val type16   = hex"160C000000002000"
    val type17   = hex"170C000000002000"
    val type18   = hex"180200"
    val type19   = hex"190201"
    val type20   = hex"200C000000002001"
    val type21   = hex"210C000000002002"
    val type22   = hex"220209"
    val tokenDataHex =
      (infoSize ++ type01 ++ type02 ++ type03 ++ type04 ++ type05 ++
        type06 ++ type07 ++ type08 ++ type09 ++ type10 ++ type11 ++
        type12 ++ type13 ++ type14 ++ type15 ++ type16 ++ type17 ++
        type18 ++ type19 ++ type20 ++ type21 ++ type22).bits

    val result = PRIVATE_DATA.decode(tokenDataHex).toOption.value.value

    result.operationType01.value.code mustBe OperationType4801.OperationType.CREDIT
    result.acceptanceCountryCode02.value.code.getAlpha3 mustBe "FRA"
    result.transactionEnvType03.value.`type` mustBe TransactionEnvType4803.EnvType.PROXIMITY_EVENT
    result.trackOrChip04.value.`type` mustBe TrackOrChip4804.EnvType.CHIP_READING
    result.originTransactionReturnCode05.value.value mustBe "00"
    result.terminalPartialAuthorSupport06.value.`type` mustBe TerminalPartialAuthorSupport4806.TerminalSupport.SUPPORT_ALL
    result.originTransactionNetwork07.value.network mustBe OriginTransactionNetwork4807.Network.BANCONTACT
    result.cashbackAmount08.value.value mustBe "000000001234"
    result.accountingPeriodNb09.value.value mustBe "1234"
    result.paymentOption10.value.option mustBe PaymentOption4810.PaymentOption.THREE_TIMES_PAYMENT
    result.transactionStatus11.value.status mustBe TransactionStatus4811.Status.NORMAL
    result.preAuthorizationValidityPeriod12.value.value mustBe "00"
    result.deviceType13.value.device mustBe DeviceType4813.Device.TAG
    result.walletType14.value.`type` mustBe WalletType4814.WalletType.GOOGLE_PAY
    result.transactionAnalysis15.value.status mustBe TransactionAnalysis4815.Status.DI
    result.transactionAnalysis15.value.reason mustBe List(TransactionAnalysis4815.Reason.CAM, TransactionAnalysis4815.Reason.CVF)
    result.offlineAccumulator1_16.value.amount mustBe "000000002000"
    result.offlineAccumulator2_17.value.amount mustBe "000000002000"
    result.resetAccumulator1_18.value.toReset mustBe true
    result.resetAccumulator2_19.value.toReset mustBe false
    result.offlineContactLimitAmount20.value.amount mustBe "000000002001"
    result.offlineContactlessLimitAmount21.value.amount mustBe "000000002002"
    result.transactionCategoryCode22.value.categoryCode mustBe TransactionCategoryCode4822.TransactionCategoryCode.UNIQUE

    val encodeResult = PRIVATE_DATA.encode(result).toOption.value
    encodeResult.toHex mustBe tokenDataHex.toHex
  }

}

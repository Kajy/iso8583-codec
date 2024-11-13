package codec.types.field48.field43

import codec.types.field48.types.AdditionalFraudData4843
import codec.types.field48.types.FraudType484302.FraudType
import org.scalatest.OptionValues
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers.convertToAnyMustWrapper
import scodec.bits.HexStringSyntax

class AdditionalFraudData4843Spec extends AnyFlatSpec with OptionValues {

  "Additional fraud data (48.43)" should "be decoded" in {
    val infoSize = hex"08"
    val type01   = hex"0106123456"
    val type02   = hex"020211"

    val tokenDataHex =
      (infoSize ++ type01 ++ type02).bits

    val result = AdditionalFraudData4843.codec.decode(tokenDataHex).toOption.value.value

    result.fraudRuleReference01.value.reference mustBe "123456"
    result.fraudType02.value.`type` mustBe FraudType.CARD_GLOBAL_RED_LIST

    val encodeResult = AdditionalFraudData4843.codec.encode(result).toOption.value
    encodeResult.toHex mustBe tokenDataHex.toHex
  }

}

package codec.types.field48.field48

import codec.types.field48.types.FraudScoringData4848
import org.scalatest.OptionValues
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers.convertToAnyMustWrapper
import scodec.bits.HexStringSyntax

class FraudScoringData4848Spec extends AnyFlatSpec with OptionValues {

  "Fraud scoring data (48.48)" should "be decoded" in {
    val infoSize = hex"12"
    val type01   = hex"0103F9F9F9"
    val type02   = hex"0202F3F4"
    val type03   = hex"0303F8F8F8"
    val type04   = hex"0402F4F3"

    val tokenDataHex =
      (infoSize ++ type01 ++ type02 ++ type03 ++ type04).bits

    val result = FraudScoringData4848.codec.decode(tokenDataHex).toOption.value.value

    result.fraudScore01.value.score mustBe "999"
    result.fraudReasonCode02.value.code mustBe "34"
    result.modelScore01.value.score mustBe "888"
    result.modelReasonCode02.value.code mustBe "43"

    val encodeResult = FraudScoringData4848.codec.encode(result).toOption.value
    encodeResult.toHex mustBe tokenDataHex.toHex
  }

}

package codec.types.field47

import codec.ISO8583Definition.ADDITIONAL_DATA
import org.scalatest.OptionValues
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers.convertToAnyMustWrapper
import scodec.bits.HexStringSyntax

class AdditionalData47Spec extends AnyFlatSpec with OptionValues {
  "Additional data (47)" should "be decoded" in {
    val infoSize = hex"05"
    val field01 = hex"0106021345"
    val addDataHex = (infoSize ++ field01).bits

    val result = ADDITIONAL_DATA.decode(addDataHex).toOption.value.value

    val result01 = result.issuerBankCode01.value
    result01.code mustBe "021345"

    val encodeResult = ADDITIONAL_DATA.encode(result).toOption.value
    encodeResult.toHex mustBe addDataHex.toHex
  }

}

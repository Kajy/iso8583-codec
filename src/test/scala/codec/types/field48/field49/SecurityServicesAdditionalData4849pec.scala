package codec.types.field48.field49

import codec.types.field48.types.SecurityServicesAdditionalData4849
import org.scalatest.OptionValues
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers.convertToAnyMustWrapper
import scodec.bits.HexStringSyntax

class SecurityServicesAdditionalData4849pec extends AnyFlatSpec with OptionValues {

  "Security Services Additional Data (48.49)" should "be decoded" in {
    val infoSize = hex"0A"
    val type01   = hex"0103F0F1F2"
    val type02   = hex"0203F4F5F6"

    val tokenDataHex =
      (infoSize ++ type01 ++ type02).bits

    val result = SecurityServicesAdditionalData4849.codec.decode(tokenDataHex).toOption.value.value

    result.securityServicesIndicator01.value.id mustBe "012"
    result.securityServicesData02.value.data mustBe "456"

    val encodeResult = SecurityServicesAdditionalData4849.codec.encode(result).toOption.value
    encodeResult.toHex mustBe tokenDataHex.toHex
  }

}

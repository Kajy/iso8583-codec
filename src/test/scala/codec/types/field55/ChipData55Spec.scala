package codec.types.field55

import codec.ISO8583Definition.CHIP_DATA
import com.neovisionaries.i18n.CountryCode
import org.scalatest.OptionValues
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers.convertToAnyMustWrapper
import scodec.bits.HexStringSyntax

class ChipData55Spec extends AnyFlatSpec with OptionValues {

  "Chip data (55)" should "be decoded" in {
    val data = hex"0D009505C1C1C1C1C19F1A040250".bits

    val decoded = CHIP_DATA.decode(data).toOption.value.value

    decoded.terminalVerificationResult01.value.result mustBe "AAAAA"
    decoded.terminalCountryCode02.value.countryCode mustBe CountryCode.FR

    CHIP_DATA.encode(decoded).toOption.value mustBe data
  }

}

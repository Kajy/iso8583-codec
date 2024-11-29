package codec.types.field90

import codec.ISO8583Definition.ORIGINAL_DATA_ELEMENTS
import org.scalatest.OptionValues
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers.convertToAnyMustWrapper
import scodec.bits.HexStringSyntax

import java.time.{ LocalTime, MonthDay }

class OriginalDataElement90Spec extends AnyFlatSpec with OptionValues {

  "Original data element (90)" should "be decoded" in {
    val data = hex"010000287611291354030000000121200000000000".bits

    val decoded = ORIGINAL_DATA_ELEMENTS.decode(data).toOption.value.value

    decoded.messageId mustBe "0100"
    decoded.auditNb mustBe "002876"
    decoded.date mustBe MonthDay.of(11, 29)
    decoded.time mustBe LocalTime.of(13, 54, 3)
    decoded.organizationId mustBe "000000012120"

    ORIGINAL_DATA_ELEMENTS.encode(decoded).toOption.value mustBe data
  }

}

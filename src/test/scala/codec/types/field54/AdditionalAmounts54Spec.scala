package codec.types.field54

import org.scalatest.OptionValues
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers.convertToAnyMustWrapper
import scodec.bits.HexStringSyntax
import utils.Currency

class AdditionalAmounts54Spec extends AnyFlatSpec with OptionValues {

  "Additional amounts (54)" should "be decoded" in {
    val data = hex"28f0f0f0f2f9f7f8c3f0f0f0f0f0f0f0f0f0f0f0f0f0f0f0f2f9f7f8c3f0f0f0f0f0f0f0f0f0f0f0f0".bits

    val decoded = AdditionalAmounts54.codec.decode(data).toOption.value.value

    decoded.datas.length mustBe 2
    decoded.datas.head.accountType mustBe "00"
    decoded.datas.head.amountType mustBe AdditionalAmounts.AmountType.AVAILABLE_BALANCE
    decoded.datas.head.currency mustBe Currency.EUR
    decoded.datas.head.side mustBe "C"
    decoded.datas.head.amount mustBe "000000000000"

    AdditionalAmounts54.codec.encode(decoded).toOption.value mustBe data
  }

}

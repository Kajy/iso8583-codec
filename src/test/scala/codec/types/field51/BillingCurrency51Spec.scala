package codec.types.field51

import codec.ISO8583Definition.BILLING_CURRENCY
import org.scalatest.OptionValues
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers.convertToAnyMustWrapper
import scodec.bits.HexStringSyntax

class BillingCurrency51Spec extends AnyFlatSpec with OptionValues {

  "Billing currency (51)" should "be decoded" in {
    val bytes = hex"0978".bits

    val result = BILLING_CURRENCY.decode(bytes).toOption.value.value

    result.currency.code mustBe "EUR"

    val encodeResult = BILLING_CURRENCY.encode(result).toOption.value
    encodeResult.toHex mustBe bytes.toHex
  }

}

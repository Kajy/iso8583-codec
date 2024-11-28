package codec.types.field49

import codec.ISO8583Definition.TRANSACTION_CURRENCY
import org.scalatest.OptionValues
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers.convertToAnyMustWrapper
import scodec.bits.HexStringSyntax

class TransactionCurrency49Spec extends AnyFlatSpec with OptionValues {

  "Transaction currency (49)" should "be decoded" in {
    val bytes = hex"0978".bits

    val result = TRANSACTION_CURRENCY.decode(bytes).toOption.value.value

    result.currency.code mustBe "EUR"

    val encodeResult = TRANSACTION_CURRENCY.encode(result).toOption.value
    encodeResult.toHex mustBe bytes.toHex
  }

}

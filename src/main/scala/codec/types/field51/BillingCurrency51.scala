package codec.types.field51

import scodec.{Codec, TransformSyntax}
import utils.Currency

case class BillingCurrency51(currency: Currency)

object BillingCurrency51 {

  val codec: Codec[BillingCurrency51] = Currency.codecN4.as[BillingCurrency51]

}

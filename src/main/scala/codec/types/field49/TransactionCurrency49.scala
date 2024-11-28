package codec.types.field49

import scodec.{Codec, TransformSyntax}
import utils.Currency

case class TransactionCurrency49(currency: Currency)

object TransactionCurrency49 {

  val codec: Codec[TransactionCurrency49] = Currency.codecN4.as[TransactionCurrency49]

}

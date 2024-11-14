package codec.types.field48.types

import codec.FieldCodecs.TLV_N
import codec.types.field48.PrivateData48XX
import scodec.{ Codec, TransformSyntax }

case class CreditCardFee4830(amount: Long) extends PrivateData48XX

object CreditCardFee4830 {
  val codec: Codec[CreditCardFee4830] = TLV_N(12).as[CreditCardFee4830]
}

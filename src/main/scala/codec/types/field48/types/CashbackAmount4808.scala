package codec.types.field48.types

import codec.FieldCodecs.TLV_N
import codec.types.field48.PrivateData48XX
import scodec.{Codec, TransformSyntax}

case class CashbackAmount4808(amount: Long) extends PrivateData48XX

object CashbackAmount4808 {
  val codec: Codec[CashbackAmount4808] = TLV_N(12).as[CashbackAmount4808]
}

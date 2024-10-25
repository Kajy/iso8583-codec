package codec.types.field48.types

import codec.FieldCodecs.LLVAR_N
import codec.types.field48.PrivateData48XX
import scodec.{ Codec, TransformSyntax }

case class CashbackAmount4808(value: String) extends PrivateData48XX

object CashbackAmount4808 {
  val codec: Codec[CashbackAmount4808] = LLVAR_N.as[CashbackAmount4808]
}

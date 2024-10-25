package codec.types.field48.types

import codec.FieldCodecs.LLVAR_N
import codec.types.field48.PrivateData48XX
import scodec.{ Codec, TransformSyntax }

case class OfflineContactLimitAmount4820(amount: String) extends PrivateData48XX

object OfflineContactLimitAmount4820 {
  val codec: Codec[OfflineContactLimitAmount4820] = LLVAR_N.as[OfflineContactLimitAmount4820]
}

package codec.types.field48.types

import codec.FieldCodecs.LLVAR_N
import codec.types.field48.PrivateData48XX
import scodec.{Codec, TransformSyntax}

case class OfflineContactlessLimitAmount4821(amount: String) extends PrivateData48XX

object OfflineContactlessLimitAmount4821 {
  val codec: Codec[OfflineContactlessLimitAmount4821] = LLVAR_N.as[OfflineContactlessLimitAmount4821]
}

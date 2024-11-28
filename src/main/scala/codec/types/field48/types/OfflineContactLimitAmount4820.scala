package codec.types.field48.types

import codec.FieldCodecs.TLV_N
import codec.types.field48.PrivateData48XX
import scodec.{Codec, TransformSyntax}

case class OfflineContactLimitAmount4820(amount: Long) extends PrivateData48XX

object OfflineContactLimitAmount4820 {
  val codec: Codec[OfflineContactLimitAmount4820] = TLV_N(12).as[OfflineContactLimitAmount4820]
}

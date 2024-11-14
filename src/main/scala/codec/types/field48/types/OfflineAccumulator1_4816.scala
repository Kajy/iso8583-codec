package codec.types.field48.types

import codec.FieldCodecs.TLV_N
import codec.types.field48.PrivateData48XX
import scodec.{ Codec, TransformSyntax }

case class OfflineAccumulator1_4816(amount: Long) extends PrivateData48XX

object OfflineAccumulator1_4816 {
  val codec: Codec[OfflineAccumulator1_4816] = TLV_N(12).as[OfflineAccumulator1_4816]
}

package codec.types.field48.types

import codec.FieldCodecs.LLVAR_N
import codec.types.field48.PrivateData48XX
import scodec.{ Codec, TransformSyntax }

case class OfflineAccumulator1_4816(amount: String) extends PrivateData48XX

object OfflineAccumulator1_4816 {
  val codec: Codec[OfflineAccumulator1_4816] = LLVAR_N.as[OfflineAccumulator1_4816]
}

package codec.types.field48.types

import codec.FieldCodecs.LLVAR_N
import codec.types.field48.PrivateData48XX
import scodec.{ Codec, TransformSyntax }

case class OfflineAccumulator2_4817(amount: String) extends PrivateData48XX

object OfflineAccumulator2_4817 {
  val codec: Codec[OfflineAccumulator2_4817] = LLVAR_N.as[OfflineAccumulator2_4817]
}

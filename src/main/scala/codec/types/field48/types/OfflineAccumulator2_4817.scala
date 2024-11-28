package codec.types.field48.types

import codec.FieldCodecs.TLV_N
import codec.types.field48.PrivateData48XX
import scodec.{Codec, TransformSyntax}

case class OfflineAccumulator2_4817(amount: Long) extends PrivateData48XX

object OfflineAccumulator2_4817 {
  val codec: Codec[OfflineAccumulator2_4817] = TLV_N(12).as[OfflineAccumulator2_4817]
}

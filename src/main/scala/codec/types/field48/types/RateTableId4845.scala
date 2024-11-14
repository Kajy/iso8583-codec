package codec.types.field48.types

import codec.FieldCodecs.LLVAR_AN
import codec.types.field48.PrivateData48XX
import scodec.{ Codec, TransformSyntax }

case class RateTableId4845(id: String) extends PrivateData48XX

object RateTableId4845 {
  val codec: Codec[RateTableId4845] = LLVAR_AN.as[RateTableId4845]
}

package codec.types.field48.types

import codec.FieldCodecs.LLVAR_AN
import codec.types.field48.PrivateData48XX
import scodec.{Codec, TransformSyntax}

case class ReferenceConversionRateSide4840(side: String) extends PrivateData48XX

object ReferenceConversionRateSide4840 {
  val codec: Codec[ReferenceConversionRateSide4840] = LLVAR_AN.as[ReferenceConversionRateSide4840]
}

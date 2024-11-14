package codec.types.field46.field1.types

import codec.FieldCodecs.LLVAR_AN
import codec.types.field46.field1.TokenData4601XX
import scodec.{Codec, TransformSyntax}

case class ConfidenceLevel460104(value: String) extends TokenData4601XX

object ConfidenceLevel460104 {
  val codec: Codec[ConfidenceLevel460104] = LLVAR_AN.as[ConfidenceLevel460104]
}

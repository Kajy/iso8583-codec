package codec.types.field46.field4.`type`

import codec.FieldCodecs.LLVAR_AN
import codec.types.field46.field4.OtherData4604XX
import scodec.{Codec, TransformSyntax}

case class CorrelationId460402(value: String) extends OtherData4604XX

object CorrelationId460402 {
  val codec: Codec[CorrelationId460402] = LLVAR_AN.as[CorrelationId460402]
}

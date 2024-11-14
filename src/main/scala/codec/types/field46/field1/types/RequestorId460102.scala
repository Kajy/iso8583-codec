package codec.types.field46.field1.types

import codec.FieldCodecs.LLVAR_N
import codec.types.field46.field1.TokenData4601XX
import scodec.{Codec, TransformSyntax}

case class RequestorId460102(id: String) extends TokenData4601XX
object RequestorId460102 {
  val codec: Codec[RequestorId460102] = LLVAR_N.as[RequestorId460102]
}

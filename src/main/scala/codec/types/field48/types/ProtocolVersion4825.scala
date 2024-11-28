package codec.types.field48.types

import codec.FieldCodecs.LLVAR_ANS
import codec.types.field48.PrivateData48XX
import scodec.{Codec, TransformSyntax}

case class ProtocolVersion4825(
    version: String
) extends PrivateData48XX

object ProtocolVersion4825 {
  val codec: Codec[ProtocolVersion4825] = LLVAR_ANS.as[ProtocolVersion4825]
}

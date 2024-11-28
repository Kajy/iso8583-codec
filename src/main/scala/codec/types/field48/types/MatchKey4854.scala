package codec.types.field48.types

import codec.FieldCodecs.LLVAR_ANS
import codec.types.field48.PrivateData48XX
import scodec.{Codec, TransformSyntax}

case class MatchKey4854(key: String) extends PrivateData48XX

object MatchKey4854 {
  val codec: Codec[MatchKey4854] = LLVAR_ANS.as[MatchKey4854]
}

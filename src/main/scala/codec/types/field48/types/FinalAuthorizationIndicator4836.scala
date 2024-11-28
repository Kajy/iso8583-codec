package codec.types.field48.types

import codec.FieldCodecs.LLVAR_N
import codec.types.field48.PrivateData48XX
import scodec.{Codec, TransformSyntax}

case class FinalAuthorizationIndicator4836(value: String) extends PrivateData48XX

object FinalAuthorizationIndicator4836 {
  val codec: Codec[FinalAuthorizationIndicator4836] = LLVAR_N.as[FinalAuthorizationIndicator4836]
}

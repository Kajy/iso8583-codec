package codec.types.field48.types

import codec.FieldCodecs.LLVAR_ANS
import codec.types.field48.PrivateData48XX
import scodec.{Codec, TransformSyntax}

case class POSPostalCode4842(code: String) extends PrivateData48XX

object POSPostalCode4842 {
  val codec: Codec[POSPostalCode4842] = LLVAR_ANS.as[POSPostalCode4842]
}

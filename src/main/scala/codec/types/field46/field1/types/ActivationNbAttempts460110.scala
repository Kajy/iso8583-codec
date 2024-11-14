package codec.types.field46.field1.types

import codec.FieldCodecs.LLVAR_N
import codec.types.field46.field1.TokenData4601XX
import scodec.{Codec, TransformSyntax}

case class ActivationNbAttempts460110(nb: String) extends TokenData4601XX

object ActivationNbAttempts460110 {

  val codec: Codec[ActivationNbAttempts460110] =
    LLVAR_N.as[ActivationNbAttempts460110]

}

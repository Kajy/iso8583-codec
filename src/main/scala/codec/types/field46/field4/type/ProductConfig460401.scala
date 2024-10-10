package codec.types.field46.field4.`type`

import codec.FieldCodecs.LLVAR_ANS
import codec.types.field46.field4.OtherData4604XX
import scodec.{Codec, TransformSyntax}

case class ProductConfig460401(value: String) extends OtherData4604XX

object ProductConfig460401 {
  val codec: Codec[ProductConfig460401] = LLVAR_ANS.as[ProductConfig460401]
}

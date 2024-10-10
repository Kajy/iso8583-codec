package codec.types.field46.field4.`type`

import codec.FieldCodecs.LLVAR_ANS
import codec.types.field46.field4.OtherData4604XX
import scodec.{Codec, TransformSyntax}

case class HolderName460406(value: String) extends OtherData4604XX

object HolderName460406 {
  val codec: Codec[HolderName460406] = LLVAR_ANS.as[HolderName460406]
}

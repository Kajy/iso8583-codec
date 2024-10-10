package codec.types.field46.field4.`type`

import codec.FieldCodecs.LLVAR_ANS
import codec.types.field46.field4.OtherData4604XX
import scodec.Codec

case class ActiveTokenNb460405(value: String) extends OtherData4604XX

object ActiveTokenNb460405 {
  val codec: Codec[ActiveTokenNb460405] = LLVAR_ANS.as[ActiveTokenNb460405]
}

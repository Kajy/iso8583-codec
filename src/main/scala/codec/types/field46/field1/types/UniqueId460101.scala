package codec.types.field46.field1.types

import codec.FieldCodecs.{AN, LLVAR}
import codec.types.TokenData4601XX
import scodec.Codec

case class UniqueId460101(id: String) extends TokenData4601XX
object UniqueId460101 {
  val codec: Codec[UniqueId460101] = LLVAR(AN).as[UniqueId460101]
}
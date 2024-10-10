package codec.types.field46.field3.types

import codec.FieldCodecs.LLVAR_ANS
import codec.types.field46.field3.DeviceData4603XX
import scodec.Codec

case class LanguageCode460306(code: String) extends DeviceData4603XX

object LanguageCode460306 {
  val codec: Codec[LanguageCode460306] = LLVAR_ANS.as[LanguageCode460306]
}

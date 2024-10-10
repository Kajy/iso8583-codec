package codec.types.field46.field1.types

import codec.FieldCodecs.LLVAR_N
import codec.types.TokenData4601XX
import scodec.Codec

case class VisaScore460105(score: String) extends TokenData4601XX

object VisaScore460105 {
  val codec: Codec[VisaScore460105] = LLVAR_N.as[VisaScore460105]
}

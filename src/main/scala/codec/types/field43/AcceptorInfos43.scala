package codec.types

import codec.FieldCodecs.ANS
import scodec.{ Codec, TransformSyntax }
import scodec.codecs.ignore
import scodec.HListCodecEnrichedWithHListSupport
import scodec.ValueCodecEnrichedWithHListSupport

case class AcceptorInfos43(name: String, city: String, countryCode: String)

object AcceptorInfos43 {

  val codec: Codec[AcceptorInfos43] =
    (ANS(22) :: ignore(8) :: ANS(13) :: ignore(8) :: ANS(3))
      .as[AcceptorInfos43]

}

package codec.types.field43

import codec.FieldCodecs.ANS
import scodec.bits.HexStringSyntax
import scodec.codecs.constant
import scodec.{ Codec, HListCodecEnrichedWithHListSupport, TransformSyntax, ValueCodecEnrichedWithHListSupport }

case class AcceptorInfos43(name: String, city: String, countryCode: String)

object AcceptorInfos43 {

  val codec: Codec[AcceptorInfos43] =
    (ANS(22) :: constant(hex"40") :: ANS(13) :: constant(hex"40") :: ANS(3))
      .as[AcceptorInfos43]

}

package codec.types.field95

import codec.FieldCodecs.N
import scodec.{ Codec, HListCodecEnrichedWithHListSupport, TransformSyntax, ValueCodecEnrichedWithHListSupport }

case class ReplacementAmount95(holderAmount: String, acceptorAmount: String, unusedData: String) {
  def toHexString = s"$holderAmount$acceptorAmount$unusedData"
}

object ReplacementAmount95 {

  val codec: Codec[ReplacementAmount95] =
    (N(12) :: N(12) :: N(18)).as[ReplacementAmount95]

}

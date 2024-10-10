package codec.types.field46.field2.types

import codec.FieldCodecs.{ANS, LLVAR}
import codec.types.WalletData4602XX
import scodec.{Codec, TransformSyntax}

case class ProviderRiskAssessmentVersion460202(version: String)
    extends WalletData4602XX

object ProviderRiskAssessmentVersion460202 {
  val codec: Codec[ProviderRiskAssessmentVersion460202] =
    LLVAR(ANS).as[ProviderRiskAssessmentVersion460202]
}

package codec.types.field48.types

import codec.FieldCodecs.{LLVAR, LLVAR_AN, N}
import codec.types.field48.PrivateData48XX
import scodec.codecs.*
import scodec.{Codec, TransformSyntax}

case class FraudScoringData4848(
    fraudScore01: Option[FraudScore484801],
    fraudReasonCode02: Option[FraudReasonCode484802],
    modelScore01: Option[ModelScore484803],
    modelReasonCode02: Option[ModelReasonCode484804],
) extends PrivateData48XX

object FraudScoringData4848 {

  private val subFieldCodec =
    discriminated[FraudScoringData4848XX]
      .by(N(2))
      .typecase("01", "FraudScore01" | FraudScore484801.codec)
      .typecase("02", "FraudReasonCode02" | FraudReasonCode484802.codec)
      .typecase("03", "ModelScore03" | ModelScore484803.codec)
      .typecase("04", "ModelReasonCode04" | ModelReasonCode484804.codec)

  val codec: Codec[FraudScoringData4848] = LLVAR(
    list(subFieldCodec).xmap(
      fields =>
        FraudScoringData4848(
          fields.collectFirst { case t: FraudScore484801 => t },
          fields.collectFirst { case t: FraudReasonCode484802 => t },
          fields.collectFirst { case t: ModelScore484803 => t },
          fields.collectFirst { case t: ModelReasonCode484804 => t },
        ),
      fsd =>
        List.concat(
          fsd.fraudScore01,
          fsd.fraudReasonCode02,
          fsd.modelScore01,
          fsd.modelReasonCode02,
        )
    )
  )

}

trait FraudScoringData4848XX

case class FraudScore484801(score: String) extends FraudScoringData4848XX

object FraudScore484801 {
  val codec: Codec[FraudScore484801] = LLVAR_AN.as[FraudScore484801]
}

case class FraudReasonCode484802(code: String) extends FraudScoringData4848XX

object FraudReasonCode484802 {

  val codec: Codec[FraudReasonCode484802] = LLVAR_AN.as[FraudReasonCode484802]
}

case class ModelScore484803(score: String) extends FraudScoringData4848XX

object ModelScore484803 {
  val codec: Codec[ModelScore484803] = LLVAR_AN.as[ModelScore484803]
}

case class ModelReasonCode484804(code: String) extends FraudScoringData4848XX

object ModelReasonCode484804 {

  val codec: Codec[ModelReasonCode484804] = LLVAR_AN.as[ModelReasonCode484804]
}

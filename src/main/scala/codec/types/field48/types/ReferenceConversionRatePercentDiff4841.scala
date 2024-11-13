package codec.types.field48.types

import codec.FieldCodecs.LLVAR_N
import codec.types.field48.PrivateData48XX
import scodec.{ Codec, TransformSyntax }

case class ReferenceConversionRatePercentDiff4841(rate: Double) extends PrivateData48XX

object ReferenceConversionRatePercentDiff4841 {

  val codec: Codec[ReferenceConversionRatePercentDiff4841] = LLVAR_N
    .xmap(
      _.toDoubleOption.fold(0d)(r => r / 100),
      (rate: Double) => {
        val intRate = (rate * 100).toInt
        String.format("%06d", intRate)
      }
    )
    .as[ReferenceConversionRatePercentDiff4841]

}

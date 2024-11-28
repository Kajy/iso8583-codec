package codec.types.field48.types

import codec.FieldCodecs.{AN, LLVAR}
import codec.types.field48.PrivateData48XX
import scodec.{Codec, TransformSyntax, ValueCodecEnrichedWithHListSupport}

case class AmountTransactionFee4827(side: String, amount: String) extends PrivateData48XX

object AmountTransactionFee4827 {
  val codec: Codec[AmountTransactionFee4827] = LLVAR(AN(1) :: AN(8)).as[AmountTransactionFee4827]
}

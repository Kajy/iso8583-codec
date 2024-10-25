package codec.types.field48.types

import codec.FieldCodecs.LLVAR_AN
import codec.types.field48.PrivateData48XX
import scodec.{Codec, TransformSyntax}

case class FinancialNetworkCode4833(code: String) extends PrivateData48XX

object FinancialNetworkCode4833 {
  val codec: Codec[FinancialNetworkCode4833] = LLVAR_AN.as[FinancialNetworkCode4833]
}

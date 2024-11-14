package codec.types.field48.types

import codec.FieldCodecs.LLVAR_ANS
import codec.types.field48.PrivateData48XX
import scodec.{ Codec, TransformSyntax }

case class ExchangeRateProvider4844(provider: String) extends PrivateData48XX

object ExchangeRateProvider4844 {
  val codec: Codec[ExchangeRateProvider4844] = LLVAR_ANS.as[ExchangeRateProvider4844]
}

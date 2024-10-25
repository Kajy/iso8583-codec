package codec.types.field48.types

import codec.FieldCodecs.LLVAR_N
import codec.types.field48.PrivateData48XX
import scodec.{ Codec, TransformSyntax }

case class PreAuthorizationValidityPeriod4812(value: String) extends PrivateData48XX

object PreAuthorizationValidityPeriod4812 {
  val codec: Codec[PreAuthorizationValidityPeriod4812] = LLVAR_N.as[PreAuthorizationValidityPeriod4812]
}

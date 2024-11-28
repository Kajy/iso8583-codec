package codec.types.field48.types

import codec.FieldCodecs.TLV_N
import codec.types.field48.PrivateData48XX
import scodec.{Codec, TransformSyntax}

case class LocalMerchantCategoryCode4831(categoryCode: Long) extends PrivateData48XX

object LocalMerchantCategoryCode4831 {
  val codec: Codec[LocalMerchantCategoryCode4831] = TLV_N(4).as[LocalMerchantCategoryCode4831]
}

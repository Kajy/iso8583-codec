package codec.types.field48.types

import codec.FieldCodecs.TLV_N
import codec.types.field48.PrivateData48XX
import com.neovisionaries.i18n.CountryCode
import scodec.Codec

case class AcceptanceCountryCode4802(code: CountryCode) extends PrivateData48XX

object AcceptanceCountryCode4802 {

  val codec: Codec[AcceptanceCountryCode4802] =
    TLV_N(4).xmap(
      s => AcceptanceCountryCode4802(CountryCode.getByCode(s.toInt)),
      cc => cc.code.getNumeric.toLong
    )

}

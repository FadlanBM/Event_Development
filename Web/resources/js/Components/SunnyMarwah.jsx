import IconMicOff from "../assets/icon-microphone-off.svg"

export default function SunnyMarwah() {
    return (
        <div className="bg-[url('../js/assets/sunnymarwah.png')] w-[156px] h-[156px]">
            <div className="flex justify-end px-2 py-2">
                <div className="flex items-center justify-center bg-white/40 rounded-full h-[24px] w-[24px]">
                    <img src={IconMicOff} />
                </div>
            </div>

            <div className="">
                <div>
                    
                </div>
            </div>
        </div>
    );
}
import natashaavatar from "../assets/natashaavatar.png";
import IconPin from "../assets/icon-pin.svg";
import IconMic from "../assets/icon-microphone.svg";
import IconVideo from "../assets/icon-video-minus.svg";
import IconCall from "../assets/icon-phone-call.svg";
import IconMail from "../assets/icon-mail.svg";
import IconFilter from "../assets/icon-color-filter.svg";

export default function NatashaSunny() {
    return (
        <div className="bg-[url('../js/assets/natashasunny.png')] h-[500px] w-[500px]">
            <div className="flex flex-col h-[500px] w-[500px]">
                <div className="flex">
                    <div className="pt-[16px] pl-[16px]">
                        <div className="bg-white/30 w-[151px] flex items-center h-[40px] px-2 gap-x-2.5 rounded-[100px] backdrop-blur-lg">
                            <img src={natashaavatar} className="rounded-full" />
                            <p className="text-[#0F1017] text-[12px]">
                                Natasha Sunny
                            </p>
                        </div>
                    </div>

                    <div className="pl-[284px] pt-[24px]">
                        <div className="bg-[#6673EA] w-[24px] h-[24px] rounded-full flex items-center justify-center">
                            <img src={IconPin} />
                        </div>
                    </div>
                </div>

                <div className="flex items-end justify-center h-[500px] w-[500px] pb-[19px]">
                    <div className="flex items-center gap-x-[16px] bg-white/30 w-[244px] h-[52px] backdrop-blur-lg rounded-[100px] border-2 px-2.5">
                        <div className="bg-[#B7B7B9] w-8 h-8 rounded-full flex items-center justify-center">
                            <img src={IconMic} />
                        </div>

                        <div className="bg-[#B7B7B9] w-8 h-8 rounded-full flex items-center justify-center">
                            <img src={IconVideo} />
                        </div>

                        <div className="bg-[#F35F5F] w-8 h-8 rounded-full flex items-center justify-center">
                            <img src={IconCall} />
                        </div>

                        <div className="bg-[#B7B7B9] w-8 h-8 rounded-full flex items-center justify-center">
                            <img src={IconMail} />
                        </div>

                        <div className="bg-[#B7B7B9] w-8 h-8 rounded-full flex items-center justify-center">
                            <img src={IconFilter} />
                        </div>

                    </div>
                </div>
            </div>
        </div>
    );
}

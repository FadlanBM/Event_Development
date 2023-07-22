import AuthenticatedLayout from "@/Layouts/AuthenticatedLayout";
import DashboardLayout from "@/Layouts/DashboardLayout";
import { Inertia } from "@inertiajs/inertia";
import { Head } from "@inertiajs/react";
import { handler } from "daisyui";
import { useState } from "react";

export default function Event({auth,props,message,data}) {
    const [name, setName] = useState("");
    const [uraian, setUraian] = useState("");
    const [tujuan, setTujuan] = useState("");
    const [tanggal, setTanggal] = useState("");
    const [waktu, setWaktu] = useState("");
    const [isNotif, setIsNotif] = useState(false);

    const handleSubmit = () => {
        const data = {
            name,
            uraian,
            tujuan,
            tanggal,
            waktu,
        };
        Inertia.post("/event/post", data);
        setIsNotif(true);
        setName("");
        setUraian("");
        setTujuan("");
        setTanggal("");
        setWaktu("");
    };

    // console.log(props);
    return (
        <DashboardLayout
            className="pt-1 flex flex-col"
            user={auth.user}
            header={<h1 className="text-2xl text-black font-medium">Event</h1>}
        >
            <Head title="Event" />

            <div className="pt-3 pl-10">
                <div className="sm:px-6 lg:px-8">
                    <div className="p-20 bg-white border-b border-gray-200 overflow-hidden sm:rounded-lg">
                        {isNotif && (
                            <div className="alert alert-success">
                                <svg
                                    xmlns="http://www.w3.org/2000/svg"
                                    className="stroke-current shrink-0 h-6 w-6"
                                    fill="none"
                                    viewBox="0 0 24 24"
                                >
                                    <path
                                        strokeLinecap="round"
                                        strokeLinejoin="round"
                                        strokeWidth="2"
                                        d="M9 12l2 2 4-4m6 2a9 9 0 11-18 0 9 9 0 0118 0z"
                                    />
                                </svg>
                                <span>{message}</span>
                            </div>
                        )}
                        <h1>{data.name}</h1>
                        <input
                            type="text"
                            placeholder="Name Event"
                            onChange={(name) =>
                                setName(name.target.value)
                            }
                            value={name}
                            className="input w-full mt-4 input-bordered bg-white md:"
                        />
                        <input
                            type="text"
                            placeholder="Uraian"
                            onChange={(uraian) =>
                                setUraian(uraian.target.value)
                            }
                            value={uraian}
                            className="input w-full mt-4 input-bordered bg-white md:"
                        />
                        <input
                            type="text"
                            placeholder="Tujuan"
                            onChange={(tujuan) =>
                                setTujuan(tujuan.target.value)
                            }
                            value={tujuan}
                            className="input w-full mt-4 input-bordered bg-white"
                        />
                        <input
                            type="date"
                            placeholder="Tanggal"
                            onChange={(tanggal) =>
                                setTanggal(tanggal.target.value)
                            }
                            value={tanggal}
                            className="input w-full mt-4 input-bordered bg-white"
                        />
                        <input
                            type="time"
                            placeholder="Time"
                            onChange={(waktu) => setWaktu(waktu.target.value)}
                            value={waktu}
                            className="input w-full mt-4 input-bordered bg-white"
                        />
                        <button
                            className="btn bbt-success mt-10 "
                            onClick={() => handleSubmit()}
                        >
                            Submit
                        </button>
                    </div>
                </div>
            </div>
        </DashboardLayout>
    );
}

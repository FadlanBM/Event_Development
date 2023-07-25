import DashboardLayout from '@/Layouts/DashboardLayout';
import { Head } from "@inertiajs/react";

export default function Dashboard({ auth, user }) {
    
    return (
        <>  
            <div className="flex flex-row">
                <DashboardLayout 
                    className="bg-[#EBDFD7]"
                />

                <div className="h-[5rem]"> 
                    <h1>asd;fh</h1>
                </div>
            


            </div>
        </>

    );
}
